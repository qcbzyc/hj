package cn.cslg.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MergeVideoMp3 {

    private String ffmpegEXE;

    public MergeVideoMp3(String ffmpegEXE) {
        super();
        this.ffmpegEXE = ffmpegEXE;
    }

    public void convertor(String videoInputPath, String Mp3InputPath,
                          double seconds,String videoOutputPath) throws Exception {
        //  ffmpeg -i
        List<String> command = new ArrayList<>();
        command.add(ffmpegEXE);
        command.add("-i");
        command.add(videoInputPath);
        command.add("-i");
        command.add(Mp3InputPath);
        command.add("-t");
        command.add(String.valueOf(seconds));
        command.add("-y");
        command.add(videoOutputPath);

        for (String c : command) {
            System.out.println(c);
        }

        ProcessBuilder builder = new ProcessBuilder(command);
        Process process = builder.start();
        // 读取子进程stderr
        InputStream errorStream = process.getErrorStream();
        InputStreamReader inputStreamReader = new InputStreamReader(errorStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String line = "";
        while ((line = bufferedReader.readLine()) != null) {

        }
        if (bufferedReader != null) {
            bufferedReader.close();
        }
        if (inputStreamReader != null) {
            inputStreamReader.close();
        }
        if (errorStream != null) {
            errorStream.close();
        }
    }

    public static void main(String[] args) {
        MergeVideoMp3 ffMpeg = new MergeVideoMp3("C:\\ffmpeg\\bin\\ffmpeg.exe");

        try {
            ffMpeg.convertor("C:\\001.mp4", "C:\\ikon.mp3",
                    19,"C:\\常熟理工.mp4");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
