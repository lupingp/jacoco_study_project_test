package com.example.studyprojectcontroller.study;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.comments.BlockComment;
import com.github.javaparser.ast.comments.Comment;
import com.github.javaparser.ast.comments.JavadocComment;
import com.github.javaparser.ast.comments.LineComment;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.stmt.Statement;
import com.github.javaparser.ast.visitor.GenericVisitorAdapter;
import com.github.javaparser.ast.visitor.ModifierVisitor;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.github.javaparser.printer.YamlPrinter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 学习Java代码解析
 */
public class StudyParser {

    public static void ParseJava() {
        File file = new File("/Users/luping/code/studyproject/src/main/java/com/example/study/project/studyproject/study/StudyNetWorkInteface.java");
        try {
            CompilationUnit compiler = JavaParser.parse(file);
            System.out.println("输出AST：" + compiler.toString());
            // 返回所有注释
            System.out.println("获取注释：");
            System.out.println(compiler.getAllContainedComments());
            System.out.println("获取类名：");
            Optional<ClassOrInterfaceDeclaration> optional1 = compiler.getClassByName("StudyNetWorkInteface");
            if (optional1.isPresent()) {
                String name = String.valueOf(optional1.get().getName());
                System.out.println("获取类名：" + name);
                System.out.println("获取类注释：" + optional1.get().getComment());
                List<Node> nodes = optional1.get().getChildNodes();
                System.out.println("获取子方法：" + nodes.size());
                for (Node no : nodes) {
                    System.out.println(no.toString());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 删除代码注释
     */


    public static void mainOne() {
        CompilationUnit compilation = JavaParser.parse("public final class CompilationUnit extends Node {\n" +
                "\n" +
                "    private PackageDeclaration packageDeclaration;}");
        YamlPrinter yamlPrinter = new YamlPrinter(true);
        System.out.println(yamlPrinter.output(compilation));
        Expression compilation1 = JavaParser.parseExpression("1+1");
        System.out.println("compilation1");
        System.out.println(compilation1);
        Statement expression = JavaParser.parseStatement("int a=0;");
        System.out.println(expression);

    }

    public static void delComment() throws Exception {
        File file = new File("/Users/luping/code/studyproject/src/main/java/com/example/study/project/studyproject/study/TestInput.java");
        CompilationUnit compilation = JavaParser.parse(file);
        List<Comment> comments = compilation.getAllContainedComments();
        comments.stream().filter(StudyParser::isValidComment).collect(Collectors.toList());
        comments.forEach(Node::remove);
        System.out.println("输出删除注释后的代码语法树");
        System.out.println(compilation);
        System.out.println("输出方法名,值为字符串：");
        VoidVisitor<Void> visitor = new MethodNamePrinter();
        MethodNamePrinter namePrinter = new MethodNamePrinter();
//        namePrinter.visit(compilation, null);
        compilation.accept(new MethodNamePrinter(), null);
        System.out.println("输出方法集合：");
        List<String> list = new ArrayList<>();
        VoidVisitor<List<String>> voidVisitor = new MethodNameCollector();
        voidVisitor.visit(compilation, list);
        System.out.println(list);
        System.out.println(list.size());
        System.out.println("IntegerLiteralModifier");
        ModifierVisitor modifierVisitor = new IntegerLiteralModifier();
//        modifierVisitor.visit(compilation,null);
        compilation.accept(new IntegerLiteralModifier(), null);
        System.out.println(compilation);

    }

    private static boolean isValidComment(Comment comment) {
        if (comment instanceof LineComment || comment instanceof BlockComment || comment instanceof JavadocComment) {
            return true;
        }
        return false;
    }

    private static class MethodNamePrinter extends VoidVisitorAdapter<Void> {
        @Override
        public void visit(MethodDeclaration n, Void arg) {

            System.out.println("方法名：" + n.getName());
            System.out.println("方法名：" + n.getNameAsString());
            StringBuilder string = new StringBuilder(n.getNameAsString());
            NodeList<Parameter> parameters = n.getParameters();
            for (Parameter p : parameters) {
                System.out.println("入参：" + p);
                System.out.println("入参类型：" + p.getType());
                if (p.getType().getChildNodes().size() > 0) {
                    string.append(",");
                    string.append(p.getType().getChildNodes().get(0));
                }
                System.out.println("入参类型子节点：" + p.getType().getChildNodes());
            }
            System.out.println("StringBuilder方法名是：" + string);
            super.visit(n, arg);
        }
    }

    private static class IntegerLiteralModifier extends ModifierVisitor<Void> {
        @Override
        public FieldDeclaration visit(FieldDeclaration n, Void arg) {
            super.visit(n, arg);
            System.out.println("IntegerLiteralModifier：" + n.toString());
            return n;
        }
    }

    private static class MethodNameCollector extends VoidVisitorAdapter<List<String>> {
        @Override
        public void visit(MethodDeclaration n, List<String> collector) {
            super.visit(n, collector);
            collector.add(n.getName().toString());
        }
    }


    public static void delComment1() throws Exception {
        File file = new File("/Users/luping/code/studyproject/src/main/java/com/example/study/project/studyproject/study/StudyThreadPoolExecute.java");
        CompilationUnit compilation = JavaParser.parse(file);
        compilation.accept(new FunctionCallVisitor(),null);
    }


    private static class FunctionCallVisitor extends GenericVisitorAdapter<Void, Void> {
        @Override
        public Void visit(MethodCallExpr n, Void arg) {
            System.out.println("function call: " + n.toString());
            String functionCall = n.toString();
            return super.visit(n, arg);
        }

        @Override
        public Void visit(MethodDeclaration n, Void arg) {
            System.out.println("function declaration: " + n.getNameAsString());
            return super.visit(n, arg);
        }
    }

    public static void main(String[] args) throws Exception {
//        StudyParser.ParseJava();
//        StudyParser.delComment();
//        StudyParser.delComment1();
//        StudyParser.mainOne();

        String logFile = "/Users/luping/code/studyproject/src".replace("example/study/project/studyproject/study/StudyGit/" + "logs/", "LOG_PATH");
        System.out.println(System.getProperty("user.home"));

    }
}


