package cracking.moderate;

public class XMLEncoding {
  void encode(Element root, StringBuilder sb) {
    encode(root.getNameCode(), sb);
    for (Attribute a : root.attributes) {
      encode(a, sb);
    }
    encode("0", sb);
    if (root.value != null && root.value != "") {
      encode(root.value, sb);
    } else {
      for (Element e : root.children) {
        encode(e, sb);
      }
    }
    encode("0", sb);
  }

  void encode(String v, StringBuilder sb) {
    sb.append(v);
    sb.append(" ");
  }

  void encode(Attribute attr, StringBuilder sb) {
    encode(attr.getTagCode(), sb);
    encode(attr.value, sb);
  }

  String encodeToString(Element root) {
    StringBuilder sb = new StringBuilder();
    encode(root, sb);
    return sb.toString();
  }
}
