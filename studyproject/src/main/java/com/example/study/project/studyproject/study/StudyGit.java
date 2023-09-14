package com.example.study.project.studyproject.study;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import org.apache.commons.io.FileUtils;
import org.eclipse.jgit.api.*;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.errors.IncorrectObjectTypeException;
import org.eclipse.jgit.errors.MissingObjectException;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectReader;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevTree;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import org.eclipse.jgit.transport.*;
import org.eclipse.jgit.treewalk.AbstractTreeIterator;
import org.eclipse.jgit.treewalk.CanonicalTreeParser;
import org.eclipse.jgit.util.FS;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 学习Git操作
 */
public class StudyGit {

    private static final UsernamePasswordCredentialsProvider usernamePasswordCredentialsProvider = new UsernamePasswordCredentialsProvider("294402584@qq.com", "456.caocao");


    static {
    }

    /**
     * 获取git操作对象
     *
     * @param path git仓库路径
     * @return
     */
    public static Git openRpo(String path) {
        Git git = null;
        try {
            Repository repository = new FileRepositoryBuilder()
                    .setGitDir(Paths.get(path, ".git").toFile())
                    .build();
            git = new Git(repository);
        } catch (IOException e) {
            System.out.println("【获取Git初始化仓库出错...】");
        }
        return git;
    }

    /**
     * 创建仓库并将代码推送到仓库
     */
    public static void gitInit() throws GitAPIException {
        Git git = Git.init().setDirectory(new File("/Users/luping/code1")).call();
    }


    /**
     * 拷贝远程仓库代码到本地
     */
    public static void cloneGit() throws GitAPIException, IOException {
        Git git1 = Git
                .cloneRepository()
                .setURI("https://github.com/lupingp/xiaocehngxu.git")
                .setCredentialsProvider(usernamePasswordCredentialsProvider)
                .setDirectory(new File("/Users/luping/code2")) // 路径必须存在
                .call();
        System.out.println(git1.toString());
    }


    public static SshSessionFactory gitSSh(){
        SshSessionFactory sshSessionFactory = new JschConfigSessionFactory(){
            @Override
            protected void configure(OpenSshConfig.Host hc, Session session) {
                session.setConfig("StrictHostKeyChecking", "no");
            }
            @Override
            protected JSch createDefaultJSch(FS fs) throws JSchException {
                JSch sch = super.createDefaultJSch(fs);
                //keyPath 公钥文件 path，执行ssh-keygen -o 命令生成，配置到账户信任key中
                sch.addIdentity("/Users/luping/.ssh/id_rsa");
                return sch;
            }
        };
        return sshSessionFactory;
    }

    /**
     * 将本地文件推送到远端
     */
    public static void pushCode() throws IOException, GitAPIException {
        CredentialsProvider provider = new UsernamePasswordCredentialsProvider("294402584@qq.com", "456.caocao");  //生成身份信息
        FileUtils.touch(new File("/Users/luping/code2/README1.md"));
        Git git = openRpo("/Users/luping/code2/");
        git.checkout().setName("lup01").call();
        git.add().addFilepattern("13.txt").call();
        git.commit().setMessage("add readme").call();
        git.push()
                .setRemote("origin")
                .setTransportConfigCallback(transport -> {
                    SshTransport sshTransport = (SshTransport) transport;
                    sshTransport.setSshSessionFactory(gitSSh());
                })
                .setRefSpecs(new RefSpec("lup01"))
                .call();
    }

    /**
     * 从远端拉取代码
     */
    public static void pullCode() throws GitAPIException {
        Git git = openRpo("/Users/luping/code2/");
        git.pull().setRemoteBranchName("master").setCredentialsProvider(usernamePasswordCredentialsProvider).call();
    }

    /**
     * 设置远程连接
     * @throws GitAPIException
     */
    public static void  setRemoteAdd() throws GitAPIException, URISyntaxException {
        Git git = openRpo("/Users/luping/code2/");
        RemoteAddCommand remoteAddCommand = git.remoteAdd();
        remoteAddCommand.setName("master");
        remoteAddCommand.setUri(new URIish("https://github.com/lupingp/xiaocehngxu.git"));
        remoteAddCommand.call();
    }

    /**
     * 删除远程连接
     * @throws GitAPIException
     */
    public static void  delRemote() throws GitAPIException, URISyntaxException {
        Git git = openRpo("/Users/luping/code2/");
        RemoteRemoveCommand remoteRemoveCommand = git.remoteRemove();
        remoteRemoveCommand.setName("master");
        remoteRemoveCommand.call();
    }

    /**
     * 获取所有远程连接
     * @throws GitAPIException
     */
    public static void getRemote() throws GitAPIException, URISyntaxException {
        Git git = openRpo("/Users/luping/code2/");
        Map<String, String> urlMap = new HashMap<>();
        List<RemoteConfig> remoteConfigs = git.remoteList().call();
        for (RemoteConfig remoteConfig: remoteConfigs) {
            urlMap.put(remoteConfig.getName(), remoteConfig.getURIs().toString());
        }
        System.out.println(urlMap);
    }

    public static void gitStatus() throws GitAPIException {
        Map<String, String> map = new HashMap<>();
        Git git = openRpo("/Users/luping/code2/");
        git.checkout().setName("lup01").call();
        Status status = git.status().call();
        map.put("Added", status.getAdded().toString());
        map.put("Changed", status.getChanged().toString());
        map.put("Conflicting", status.getConflicting().toString());
        map.put("ConflictingStageState", status.getConflictingStageState().toString());
        map.put("IgnoredNotInIndex", status.getIgnoredNotInIndex().toString());
        map.put("Missing", status.getMissing().toString());
        map.put("Modified", status.getModified().toString());
        map.put("Removed", status.getRemoved().toString());
        map.put("UntrackedFiles", status.getUntracked().toString());
        map.put("UntrackedFolders", status.getUntrackedFolders().toString());
        System.out.println(map);
    }

    /**
     * 创建分支并切换分支
     */
    public static void createdBrandName() throws GitAPIException {
        Git git = openRpo("/Users/luping/code2/");
        // 创建分支
        git.branchCreate().setName("lup01").call();
        // 切换分支
        git.checkout().setName("lup01").call();

    }

    /**
     * 查找所以分支
     */
    public static void branchList() throws GitAPIException {
        Git git = openRpo("/Users/luping/code2/");
        List<Ref> call = git.branchList().call();
        for (Ref ref : call) {
            System.out.println("【分支名】：" + ref.getName());
        }

        // 结果：
        //【分支名】：Ref[refs/heads/lup01=14c74591f855f65462b1aba43c9c9d2a6c24bb4f]
        //【分支名】：Ref[refs/heads/master=14c74591f855f65462b1aba43c9c9d2a6c24bb4f]
        // 使用getname
        //【分支名】：refs/heads/lup01
        //【分支名】：refs/heads/master
    }

    /**
     * 删除分支
     */
    public static void delBrandName() throws GitAPIException {
        Git git = openRpo("/Users/luping/code2/");
        git.branchDelete().setBranchNames("lup01").call();
    }

    /**
     * 合并分支
     * @throws GitAPIException
     */
    public static void mergeBranch() throws GitAPIException, IOException {
        Git git = openRpo("/Users/luping/code2/");
        Ref lup01 = git.checkout().setName("lup01").call();
        FileUtils.touch(new File("/Users/luping/code2/13.txt"));
        git.checkout().setName("master").call();
        MergeResult mergeResult = git.merge().include(lup01).setCommit(true).setFastForward(MergeCommand.FastForwardMode.NO_FF).setMessage("测试1").call();
        System.out.println(mergeResult);
        System.out.println(mergeResult.getMergeStatus());
    }

    /**
     * diff对比
     */
    public static void gitDiff() throws IOException, GitAPIException {
        Git git = openRpo("/Users/luping/code2/");
        System.out.println("测试:"+git.getRepository().getDirectory().getParent());
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        System.out.println("git.getRepository().resolve(\"HEAD\").getName()："+git.getRepository().resolve("HEAD").getName());
        System.out.println("git.getRepository().resolve(\"HEAD\").getName()："+git.getRepository().resolve("HEAD^").getName());
        AbstractTreeIterator tree1 = prepareTreeParser(git.getRepository(),git.getRepository().resolve("HEAD").getName());
        AbstractTreeIterator tree2 = prepareTreeParser(git.getRepository(),git.getRepository().resolve("HEAD^").getName());
        git.diff().setNewTree(tree1).setOldTree(tree2).setOutputStream(stream).call();
        System.out.println(stream);
    }

    private static AbstractTreeIterator prepareTreeParser(Repository repository, String head) {
        try(RevWalk walk = new RevWalk(repository)) {
            RevCommit revCommit = walk.parseCommit(ObjectId.fromString(head));
            RevTree tree = walk.parseTree(revCommit.getTree().getId());
            CanonicalTreeParser parser = new CanonicalTreeParser();
           try(ObjectReader reader = repository.newObjectReader()) {
               parser.reset(reader,tree.getId());
           }
           walk.dispose();
           return parser;
        } catch (IncorrectObjectTypeException e) {
            throw new RuntimeException(e);
        } catch (MissingObjectException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws GitAPIException, IOException, URISyntaxException {
//        StudyGit.cloneGit();
        // Push
//        StudyGit.pushCode();
        // pull
//        StudyGit.pullCode();
//        StudyGit.getRemote();
        // diff
        StudyGit.gitDiff();
//        StudyGit.delRemote();
        // 设置远程连接
//        StudyGit.setRemoteAdd();
        // git状态
//        StudyGit.gitStatus();

//        System.out.println(StudyGit.openRpo("/Users/luping/code2/"));;

        // 创建分支 和 切换分支
//        StudyGit.createdBrandName();
        // 删除分支
//        StudyGit.delBrandName();
        // 查找全部分支
//        StudyGit.branchList();
        // 分支合并
//        StudyGit.mergeBranch();
    }
}
