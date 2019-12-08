package cn.cslg.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FFMpegTest {

    private String ffmpegEXE;

    public FFMpegTest(String ffmpegEXE) {
        super();
        this.ffmpegEXE = ffmpegEXE;
    }

    public void convertor(String videoInputPath, String videoOutputPath) throws Exception {
        //  ffmpeg -i
        List<String> command = new ArrayList<>();
        command.add(ffmpegEXE);
        command.add("-i");
        command.add(videoInputPath);
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
        FFMpegTest ffMpeg = new FFMpegTest("C:\\ffmpeg\\bin\\ffmpeg.exe");

        try {
            ffMpeg.convertor("C:\\001.mp4", "C:\\常熟理工.avi");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
