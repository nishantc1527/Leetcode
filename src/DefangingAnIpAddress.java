public class DefangingAnIpAddress {

  public static void main(String[] args) {
    System.out.println(new DefangingAnIpAddress().defangIPaddr("1.1.1.1"));
  }

  public String defangIPaddr(String address) {
    return address.replace(".", "[.]");
  }

}
