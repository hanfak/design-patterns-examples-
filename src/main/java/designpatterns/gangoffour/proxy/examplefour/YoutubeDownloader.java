package designpatterns.gangoffour.proxy.examplefour;

import java.util.Map;

// The GUI class, which used to work directly with a service
// object, stays unchanged as long as it works with the service
// object through an interface. We can safely pass a proxy
// object instead of a real service object since they both
// implement the same interface.
public class YoutubeDownloader {
  private ThirdPartyYoutubeLib api;

  public YoutubeDownloader(ThirdPartyYoutubeLib api) {
    this.api = api;
  }
  // Render the video page.
  public void renderVideoPage(String videoId) {
    Video video = api.getVideo(videoId);
    System.out.println("\n-------------------------------");
    System.out.println("Video page (imagine fancy HTML)");
    System.out.println("ID: " + video.id);
    System.out.println("Title: " + video.title);
    System.out.println("Video: " + video.data);
    System.out.println("-------------------------------\n");
  }
  // Render the list of video thumbnails.
  public void renderPopularVideos() {
    Map<String, Video> list = api.popularVideos();
    System.out.println("\n-------------------------------");
    System.out.println("Most popular videos on Youtube (imagine fancy HTML)");
    for (Video video : list.values()) {
      System.out.println("ID: " + video.id + " / Title: " + video.title);
    }
    System.out.println("-------------------------------\n");
  }
}