
import java.nio.ByteBuffer;
 
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.util.Duration;


//te 3
import java.nio.file.Files;
import java.io.File;
import java.io.IOException;
//te 4
import java.io.ByteArrayOutputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;


 
import cam.Frames;

public class Cam extends Application 
 {
  private static final int FRAME_WIDTH  = 640;
  private static final int FRAME_HEIGHT = 480;  


    GraphicsContext gc;
    Canvas canvas;
    byte buffer[];  
    PixelWriter pixelWriter; 
    PixelFormat<ByteBuffer> pixelFormat;

    Frames frames;
         
    public static void main(String[] args) 
     {
      launch(args);
     }

    @Override
    public void start(Stage primaryStage) 
     {
      int result;
      
      Timeline timeline;
      
      frames = new Frames();
      
      result = frames.open_shm("/frames");      
      
      primaryStage.setTitle("Camera");
      Scene scene;
      
      Group root = new Group();
      canvas     = new Canvas(650, 490);
      gc         = canvas.getGraphicsContext2D();

                
 
      timeline = new Timeline(new KeyFrame(Duration.millis(130), e->disp_frame()));

      timeline.setCycleCount(Timeline.INDEFINITE);

      timeline.play();
 
      root.getChildren().add(canvas);
      scene = new Scene(root);
      primaryStage.setScene(scene);
      primaryStage.show();
    }
    
    private void disp_frame()
     {
      
      pixelWriter = gc.getPixelWriter();
      pixelFormat = PixelFormat.getByteRgbInstance();

      buffer = frames.get_frame();  

      pixelWriter.setPixels(0, 0, FRAME_WIDTH, FRAME_HEIGHT, pixelFormat, buffer, 0, FRAME_WIDTH*3);
      
     }
    
 }




 
















