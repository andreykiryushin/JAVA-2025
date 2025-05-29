package lr2;

// Интерфейс для банковских операций
interface BankAccountOperations {
    void createAccount(String accountNumber, double initialBalance);
    void deposit(double amount);
    void withdraw(double amount) throws InsufficientFundsException;
    double getBalance();
}

// Исключение для случая недостатка средств
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

// Класс банковского счета
class BankAccount implements BankAccountOperations {
    private String accountNumber;
    private double balance;

    @Override
    public void createAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        System.out.println("Счет " + accountNumber + " создан. Начальный баланс: " + initialBalance);
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Внесено: " + amount + ". Новый баланс: " + balance);
        } else {
            System.out.println("Сумма депозита должна быть положительной");
        }
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Недостаточно средств. Текущий баланс: " + balance);
        }
        balance -= amount;
        System.out.println("Снято: " + amount + ". Остаток на счете: " + balance);
    }

    @Override
    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}

// Главный класс для демонстрации работы
public class Example7 {
    public static void main(String[] args) {
        // Создаем банковский счет
        BankAccountOperations account = new BankAccount();
        account.createAccount("123456789", 1000.0);

        // Выполняем операции
        account.deposit(500.0);

        try {
            account.withdraw(200.0);
            account.withdraw(2000.0); // Это вызовет исключение
        } catch (InsufficientFundsException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        // Проверяем баланс
        System.out.println("Текущий баланс счета " + ((BankAccount)account).getAccountNumber() +
                ": " + account.getBalance());
    }
}