public class Knoten {
  String type;

  Knoten (String type) {
    this.type = type.toLowerCase();
    switch (this.type) {
      case "base":
      case "word":
      case "root":
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

