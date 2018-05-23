public class TerminalKnoten extends Knoten {
  private String form;
  private String subtype;


  TerminalKnoten(String type, String form, String subtype) {
    super(type);
    this.form = form;
    this.subtype = subtype;

    if (this.getType() == "affix") {
      switch (this.subtype) { 
        case "D":
          break; // nach jedem case ein break
        case "I": // hier sollen wir nur "I" verwenden siehe mail
          break;
        default:
          this.subtype = "";
          break;
      }
    }

  }

  public String getForm() {
    return this.form;
  }

  public String getSubtype() {
    return this.subtype;
  }

  @Override
  public String toString() {
    return  getType() + ":" + getForm() + ":" + getSubtype();
  }
}
