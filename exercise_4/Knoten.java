public class Knoten {
  private String type;

  Knoten (String type) {
    this.type = type.toLowerCase();
    switch (this.type) {
      case "base":
        break;
      case "word":
        break;
      case "root":
        break;
      case "affix":
        break;
      default:
        this.type = "";
        break;
    }
  }

  public String getType() {
    return this.type;
  }

  @Override
  public String toString() {
    return getType();
  }
}

