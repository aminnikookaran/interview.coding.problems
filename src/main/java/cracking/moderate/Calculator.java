package cracking.moderate;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Calculator {
  /* Compute the result of the arithmetic sequence. This works by reading left to
   * right and applying each term to a result. When we see a multiplication or
   * division, we instead apply this sequence to a temporary variable. */
  double compute1(String sequence) {
    List<Term> terms = Term.parseTermSequence(sequence);
    if (terms == null) return Integer.MIN_VALUE;
    double result = 0;
    Term processing = null;
    for (int i = 0; i < terms.size(); i++) {
      Term current = terms.get(i);
      Term next = i + 1 < terms.size() ? terms.get(i + 1) : null;
      /* Apply the current term to "processing". */
      processing = collapseTerm1(processing, current);

      /* If next term is + or -, then this cluster is done and we should apply
       * "processing" to "result". */
      if (next == null
          || next.getOperator() == Operator.ADD
          || next.getOperator() == Operator.SUBTRACT) {
        result = applyOp1(result, processing.getOperator(), processing.getNumber());
        processing = null;
      }
    }

    return result;
  }

  /* Collapse two terms together using the operator in secondary and the numbers
   * from each. */
  Term collapseTerm1(Term primary, Term secondary) {
    if (primary == null) return secondary;
    if (secondary == null) return primary;

    double value = applyOp1(primary.getNumber(), secondary.getOperator(), secondary.getNumber());
    primary.setNumber(value);
    return primary;
  }

  double applyOp1(double left, Operator op, double right) {
    if (op == Operator.ADD) return left + right;
    else if (op == Operator.SUBTRACT) return left - right;
    else if (op == Operator.MULTIPLY) return left * right;
    else if (op == Operator.DIVIDE) return left / right;
    else return right;
  }

  public static class Term {
    private double value;
    private Operator operator = Operator.BLANK;

    public Term(double v, Operator op) {
      value = v;
      operator = op;
    }

    public double getNumber() {
      return value;
    }

    public Operator getOperator() {
      return operator;
    }

    public void setNumber(double v) {
      value = v;
    }
    /* Parses arithmetic sequence into a list of Terms. For example, 3-5*6 becomes
     * something like: [{BLANK,3}, {SUBTRACT, 5}, {MULTIPLY, 6}}.
     * If improperly formatted, returns null. */
    public static ArrayList<Term> parseTermSequence(String sequence) {
      /* Code can be found in downloadable solutions. */
      return null;
    }
  }

  public enum Operator {
    ADD,
    SUBTRACT,
    MULTIPLY,
    DIVIDE,
    BLANK
  }

  double compute(String sequence) {
    Stack<Double> numberStack = new Stack<Double>();
    Stack<Operator> operatorStack = new Stack<Operator>();

    for (int i = 0; i < sequence.length(); i++)
      try {
        /* Get number and push. */
        int value = parseNextNumber(sequence, i);
        numberStack.push((double) value);

        /* Move to the operator. */
        i += Integer.toString(value).length();
        if (i >= sequence.length()) break;

        /* Get operator, collapse top as needed, push operator. */
        Operator op = parseNextOperator(sequence, i);
        collapseTop(op, numberStack, operatorStack);
        operatorStack.push(op);
      } catch (NumberFormatException ex) {
        return Integer.MIN_VALUE;
      }

    /* Do final collapse. */
    collapseTop(Operator.BLANK, numberStack, operatorStack);
    if (numberStack.size() == 1 && operatorStack.size() == 0) return numberStack.pop();
    return 0;
  }

  /* Collapse top until priority(futureTop) > priority(top). Collapsing means to pop
   * the top 2 numbers and apply the operator popped from the top of the operator
   * stack, and then push that onto the numbers stack.*/
  void collapseTop(Operator futureTop, Stack<Double> numberStack, Stack<Operator> operatorStack) {
    while (operatorStack.size() >= 1 && numberStack.size() >= 2)
      if (priorityOfOperator(futureTop) <= priorityOfOperator(operatorStack.peek())) {
        double second = numberStack.pop();
        double first = numberStack.pop();
        Operator op = operatorStack.pop();
        double collapsed = applyOp(first, op, second);
        numberStack.push(collapsed);
      } else break;
  }

  /* Return priority of operator. Mapped so that:
   * addition== subtraction< multiplication division. */
  int priorityOfOperator(Operator op) {
    switch (op) {
      case ADD:
        return 1;
      case SUBTRACT:
        return 1;
      case MULTIPLY:
        return 2;
      case DIVIDE:
        return 2;
      case BLANK:
        return 0;
    }
    return 0;
  }

  /* Apply operator: left [op] right. */
  double applyOp(double left, Operator op, double right) {
    if (op == Operator.ADD) return left + right;
    else if (op == Operator.SUBTRACT) return left - right;
    else if (op == Operator.MULTIPLY) return left * right;
    else if (op == Operator.DIVIDE) return left / right;
    else return right;
  }

  /* Return the number that starts at offset. */
  int parseNextNumber(String seq, int offset) {
    StringBuilder sb = new StringBuilder();
    while (offset < seq.length() && Character.isDigit(seq.charAt(offset))) {
      sb.append(seq.charAt(offset));
      offset++;
    }
    return Integer.parseInt(sb.toString());
  }

  /* Return the operator that occurs as offset. */
  Operator parseNextOperator(String sequence, int offset) {
    if (offset < sequence.length()) {
      char op = sequence.charAt(offset);
      switch (op) {
        case '+':
          return Operator.ADD;
        case '-':
          return Operator.SUBTRACT;
        case '*':
          return Operator.MULTIPLY;
        case '/':
          return Operator.DIVIDE;
      }
    }
    return Operator.BLANK;
  }
}
