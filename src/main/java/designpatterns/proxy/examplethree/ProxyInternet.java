package designpatterns.proxy.examplethree;

import java.util.ArrayList;
import java.util.List;

public class ProxyInternet implements Internet {
  private final Internet internet = new RealInternet();
  private static final List<String> bannedSites;

  static {
    bannedSites = new ArrayList<>();
    bannedSites.add("abc.com");
    bannedSites.add("def.com");
    bannedSites.add("ijk.com");
    bannedSites.add("lnm.com");
  }

  @Override
  public void connectTo(String serverhost) throws Exception {
    if (bannedSites.contains(serverhost.toLowerCase())) {
      throw new Exception("Access Denied");
    }

    internet.connectTo(serverhost);
  }

}
