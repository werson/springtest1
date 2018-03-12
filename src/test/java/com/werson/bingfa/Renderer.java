package com.werson.bingfa;

import com.sun.scenario.effect.ImageData;
import org.junit.Test;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by wersom on 2018/3/9.
 */
public class Renderer {

    private final ExecutorService executor = new ;

    public Renderer(){}
    
    /*public Renderer(ExecutorService executor){
        this.executor = executor;
    }*/

    private String formatStr(String str) throws InterruptedException {
        Thread.sleep(200L);
        return new StringBuilder(str).append("00000").toString();
    }

    public void renderPage(String param){
        final List<String> info = Arrays.asList(param);
        CompletionService<String> completionService =
                new ExecutorCompletionService<>(executor);
        for (final String imageStr : info){
            completionService.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return formatStr(imageStr);
                }
            });
        }

        try{
            for (int i = 0, n = info.size(); i < n; i++){
                Future<String> f = completionService.take();
                String a = f.get();
                System.out.println(a);
            }
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void renderPageTest(){
        renderPage("hahaha");
    }

}
