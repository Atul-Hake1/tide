package com.tide.qa.utility;

import static org.monte.media.FormatKeys.EncodingKey;
import static org.monte.media.FormatKeys.FrameRateKey;
import static org.monte.media.FormatKeys.KeyFrameIntervalKey;
import static org.monte.media.FormatKeys.MIME_AVI;
import static org.monte.media.FormatKeys.MediaTypeKey;
import static org.monte.media.FormatKeys.MimeTypeKey;
import static org.monte.media.VideoFormatKeys.CompressorNameKey;
import static org.monte.media.VideoFormatKeys.DepthKey;
import static org.monte.media.VideoFormatKeys.ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE;
import static org.monte.media.VideoFormatKeys.QualityKey;

import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.io.IOException;

import org.monte.media.Format;
import org.monte.media.FormatKeys.MediaType;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
import java.io.File;
import java.awt.*;

public class RecordVideo 
{
	/** The screen recorder. */
	  private ScreenRecorder screenRecorder = null;

	  /**
	   * Instantiates a new video recorder and starts recording.
	 * @return 
	   */
	  public void startVideoRecording(String VideosPath, String FileName) 
	  {
	    //System.out.println("Initializing Video Recorder ...");
	    try {
	    	
	    	File file = new File(VideosPath);
            
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            int width = screenSize.width;
            int height = screenSize.height;
                           
            Rectangle captureSize = new Rectangle(0,0, width, height);
	      
            GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment()
	          .getDefaultScreenDevice().getDefaultConfiguration();

            this.screenRecorder = new SpecializedScreenRecorder(gc, captureSize,
                    new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
                    new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                         CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                         DepthKey, 24, FrameRateKey, Rational.valueOf(15),
                         QualityKey, 1.0f,
                         KeyFrameIntervalKey, 15 * 60),
                    new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black",
                         FrameRateKey, Rational.valueOf(30)),
                    null, file, FileName);
          
            //System.out.println("Starting Video Recording ....");
            this.screenRecorder.start();
               
	    } catch (Exception e) {
	        System.out.println("problem in Starting the Video Recording.");
			System.out.println(e.getMessage());
	    }
	  }

	  /**
	   * Stop video recording.
	   */
	  public void stopVideoRecording() {
	    try {
	      //System.out.println("Stopping Video Recording.");
	      this.screenRecorder.stop();
	    } catch (IOException e) {
	      System.out.println("problem in stopping the Video Recording");
	      System.out.println(e.getMessage());
	    }
	  }
}
