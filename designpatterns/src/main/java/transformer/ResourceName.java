package transformer;

import java.util.Optional;

public enum ResourceName {

  ONNET_MPF("ONNET-MPF"),
  FTTP_TALKTALK("FTTP-TALKTALK");

  private final String apiName;

  ResourceName(String apiName) {
    this.apiName = apiName;
  }

  public String changeData() {
    return "Product is " + apiName;
  }


  public static ResourceName fromApiName(String apiName) {
    for (ResourceName resourceName : values()) {
      if (resourceName.apiName.equalsIgnoreCase(apiName.trim())) {
        return resourceName;
      }
    }
    throw new IllegalArgumentException("No known Resource for input value " + apiName);
  }

  public static Optional<ResourceName> fromApiNameV2(String apiName) {
    for (ResourceName resourceName : values()) {
      if (resourceName.apiName.equalsIgnoreCase(apiName.trim())) {
        return Optional.of(resourceName);
      }
    }
    return Optional.empty();
  }
}

