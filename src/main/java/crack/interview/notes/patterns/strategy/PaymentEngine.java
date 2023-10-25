package crack.interview.notes.patterns.strategy;

public final class PaymentEngine {

    private Strategy strategy;

    PaymentEngine(Strategy strategy) {
        this.strategy = strategy;
    }

    boolean pay() {
        strategy.pay();
        return true;
    }

    void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public static void main(String[] args) {
        Strategy strategy = new Moneris();
        PaymentEngine paymentEngine = new PaymentEngine(strategy);
        paymentEngine.pay();
        paymentEngine.setStrategy(new Bombaris());
        paymentEngine.pay();
    }
}
