package designpatterns.gangoffour.state.examplethree.before;

public class Medium implements State {
  @Override
  public void pull(CeilingFanPullChain wrapper) {
    wrapper.set_state(new High());
    System.out.println("high speed");
  }
}
