package gangoffour.state.examplethree.before;

public class Off implements State {
  @Override
  public void pull(CeilingFanPullChain wrapper) {
    wrapper.set_state(new Low());
    System.out.println("low speed");
  }
}
