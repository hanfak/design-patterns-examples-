package gangoffour.proxy.examplefour;

import java.util.Map;

// The interface of a remote service.
public interface ThirdPartyYoutubeLib {
  Map<String, Video> popularVideos();

  Video getVideo(String videoId);
}
