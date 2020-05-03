package enterprisepatterns.finitestatemachine;

public enum Events {
  FIRST_EVENT {
    @Override
    public Events nextEvent() {
      return null;
    }
  },
  SECOND_EVENT {
    @Override
    public Events nextEvent() {
      return SECOND_EVENT;
    }
  },
  THIRD_ONE_EVENT {
    @Override
    public Events nextEvent() {
      return FOURTH_EVENT;
    }
  },
  THIRD_TWO_EVENT {
    @Override
    public Events nextEvent() {
      return THIRD_ONE_EVENT;
    }
  },
  FOURTH_EVENT {
    @Override
    public Events nextEvent() {
      return FIRST_EVENT;
    }
  };

  public abstract Events nextEvent();
}
