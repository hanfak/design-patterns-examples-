package designpatterns.gangoffour.state.examplethree.before;

public class High implements State {
  @Override
  public void pull(CeilingFanPullChain wrapper) {
    wrapper.set_state(new Off());
    System.out.println("turning off");
  }
}
