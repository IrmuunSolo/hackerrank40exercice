# Cycle Detection

[![]( https://img.shields.io/badge/Бодлогын_линк-blue)](https://www.hackerrank.com/challenges/detect-whether-a-linked-list-contains-a-cycle/problem?isFullScreen=true)

## Бодлогын тайлбар

Холбоотой жагсаалт (linked list) нь гогцоо агуулж байна гэдэг нь жагсаалтыг дайран өнгөрөх үед ямар нэг зангилааг (node) нэгээс олон удаа давтан орсон тохиолдолд юм. Холбоотой жагсаалтын толгойн (head) зангилааг зааж өгсөн бол энэ жагсаалт гогцоо агуулж байгаа эсэхийг тодорхойл. Хэрэв гогцоо байвал 1-ийг, үгүй бол 0-ийг буцаа.

**Жишээ:**

head зангилаа нь 1→2→3→NULL жагсаалтыг зааж байна.

Энд гогцоо байхгүй тул 0-ийг буцаана.

head зангилаа нь 1→2→3→1→NULL жагсаалтыг зааж байна.

Энд 3-р зангилаа 1-р зангилаа руу буцаж заасан гогцоо байгаа тул 1-ийг буцаана.

**Функцийн Тодорхойлолт:**

Доорх has_cycle функцийг гүйцээ.

**Параметр:**

- SinglyLinkedListNode pointer head: жагсаалтын толгойн зангилааны хаяг

**Буцаах утга:**

- int: гогцоо байвал 1, үгүй бол 0

Анхаар: Хэрэв жагсаалт хоосон бол head нь null байна.

**Оролтын Формат:**

Код нь stdin-ээс уншиж, тохирох аргументыг функцийг руу дамжуулна. 

## Бодолт:

**Тайлбар:**

1. SinglyLinkedListNode класс нь холбоотой жагсаалтын зангилааг тодорхойлдог.

```
    static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;
        SinglyLinkedListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }
```

2. hasCycle функц нь гогцоо байгаа эсэхийг шалгадаг:

- Хэрэв жагсаалт хоосон бол (head == null) гогцоо байхгүй тул false буцаана.
- slow (удаан) болон fast (хурдан) заагчийг ашиглан жагсаалтыг давтана.
- Хэрэв slow == fast бол гогцоо байгаа гэсэн үг тул true буцаана.

```
    static boolean hasCycle(SinglyLinkedListNode head) {
        if (head == null) {
            return false;
        }
        
        SinglyLinkedListNode slow = head;
        SinglyLinkedListNode fast = head.next;
        
        while (fast != null && fast.next != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return false;
    }
```

3. main функц нь оролтыг уншиж, тест хийх жагсаалт үүсгэдэг:

- Эхний тоо нь тестийн тоо.
- Дараагийн тоо нь гогцоо эхлэх индексийг заана (-1 бол гогцоо байхгүй).
- Үүний дараа жагсаалтын зангилаануудын тоо болон утгуудыг уншина.
- Хэрэв индекс -1-ээс их бол гогцоо үүсгэнэ.
- Эцэст нь hasCycle функцийг дуудаж үр дүнг хэвлэнэ.

```
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();
        
        for (int t = 0; t < tests; t++) {
            int index = scanner.nextInt();
            
            int nodeCount = scanner.nextInt();
            SinglyLinkedListNode head = new SinglyLinkedListNode(scanner.nextInt());
            SinglyLinkedListNode current = head;
            SinglyLinkedListNode cycleNode = null;
            
            for (int i = 1; i < nodeCount; i++) {
                current.next = new SinglyLinkedListNode(scanner.nextInt());
                current = current.next;
                if (i == index) {
                    cycleNode = current;
                }
            }
            
            if (index >= 0 && cycleNode != null) {
                current.next = cycleNode;
            }
            
            System.out.println(hasCycle(head) ? 1 : 0);
        }
```


## Submit screenshot

![Submit](/images/22.submit.png)

