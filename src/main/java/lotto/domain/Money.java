package lotto.domain;

import static lotto.ErrorMessage.MONEY_NEGATIVE_ERROR;

import java.util.Objects;

public final class Money {
    private final int money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int money) {
        if (money <= 0) {
            throw new IllegalArgumentException(MONEY_NEGATIVE_ERROR.getMessage());
        }
    }

    public boolean canPurchase(int price) {
        return money % price == 0 && money >= price;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Money otherMoney)) {
            return false;
        }

        return this.money == otherMoney.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}
