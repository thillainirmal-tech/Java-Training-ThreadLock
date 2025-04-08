# 🔐 Java Synchronized vs Redundant Lock

This project demonstrates the correct usage of `synchronized` in Java and highlights what constitutes a **redundant lock**. It's aimed at helping developers understand proper thread synchronization practices.

---

## 📌 Features

- Correct usage of `synchronized` method and blocks
- Examples of redundant locking
- Thread-safe counter example
- Output comparison for clarity

---

## 📂 Project Structure

```
lock-example/
│
├── src/
│   ├── Counter.java
│   ├── RedundantLockExample.java
│   ├── ProperLockExample.java
│   └── Main.java
│
├── README.md
└── LICENSE
```

---

## 🚀 Getting Started

### Prerequisites

- Java 8 or higher
- IDE (IntelliJ, Eclipse) or terminal

### Compile & Run

```bash
javac src/*.java
java src.Main
```

---

## ✅ Proper Lock Usage

```java
public class Counter {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}
```

- Synchronization is correctly used to ensure thread safety.

---

## ⚠️ Redundant Lock Example

```java
public class RedundantLockExample {
    public synchronized void printMessage() {
        synchronized (this) { // 🚫 Redundant Lock
            System.out.println("Hello from RedundantLockExample");
        }
    }
}
```

- This is a redundant lock because the method is already synchronized.

---

## 📸 Output Example

```
Proper Counter: 1000
Redundant Lock: Message printed with unnecessary synchronization
```

---

## 🧑‍💻 Author

**Thillai Nirmal**  
[GitHub](https://github.com/thillainirmal-tech)

---

## 🪪 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
