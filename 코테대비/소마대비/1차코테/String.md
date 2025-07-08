# String 및 StringBuilder 메서드 정리

## `String.toLowerCase()`
`toLowerCase()` 메서드는 문자열의 모든 문자를 소문자로 변환하여 새로운 문자열을 반환합니다.

### 사용법
```java
String str = "Hello World";
String lowerStr = str.toLowerCase();
System.out.println(lowerStr); // "hello world"
```

### 특징
- 원본 문자열은 변경되지 않음 (불변 객체 특성)
- 영어 알파벳 이외의 문자는 영향을 받지 않음

---

## `String.toUpperCase()`
`toUpperCase()` 메서드는 문자열의 모든 문자를 대문자로 변환하여 새로운 문자열을 반환합니다.

### 사용법
```java
String str = "hello world";
String upperStr = str.toUpperCase();
System.out.println(upperStr); // "HELLO WORLD"
```

### 특징
- 원본 문자열은 변경되지 않음
- 영어 알파벳 이외의 문자는 영향을 받지 않음

---

## `String.charAt(int index)`
`charAt()` 메서드는 지정한 인덱스에 있는 문자를 반환합니다.

### 사용법
```java
String str = "hello";
char ch = str.charAt(1);
System.out.println(ch); // 'e'
```

### 특징
- 문자열의 특정 위치에 있는 문자에 접근할 때 사용
- 유효하지 않은 인덱스를 전달하면 `StringIndexOutOfBoundsException` 발생

---
## `String.split(String regex)`
`split()` 메서드는 지정한 정규 표현식을 기준으로 문자열을 나누어 배열로 반환합니다.

### 사용법
```java
String str = "hello world java";
String[] words = str.split(" ");
for (String word : words) {
    System.out.println(word);
}
```

### 출력
```
hello
world
java
```

### 특징
- 여러 개의 공백을 기준으로 나눌 경우 `split(" +")`을 사용하면 연속된 공백도 하나로 처리 가능
- 빈 문자열을 기준으로 나누려면 `split("")` 사용 가능
- 제한된 개수만큼 나누려면 `split(String regex, int limit)` 사용 가능

### 다양한 예제
```java
String csv = "apple,banana,cherry";
String[] fruits = csv.split(",");
System.out.println(Arrays.toString(fruits)); // ["apple", "banana", "cherry"]

String text = "one..two...three";
String[] parts = text.split("\\.+"); // 점이 하나 이상 연속된 부분을 기준으로 분리
System.out.println(Arrays.toString(parts)); // ["one", "two", "three"]
```
---

## `StringBuilder.deleteCharAt(int index)`
`deleteCharAt()` 메서드는 `StringBuilder` 객체에서 특정 인덱스의 문자를 제거합니다.

### 사용법
```java
StringBuilder sb = new StringBuilder("hello");
sb.deleteCharAt(1);
System.out.println(sb); // "hllo"
```

### 특징
- 지정한 위치의 문자만 삭제됨
- `StringBuilder`는 변경 가능한(mutable) 객체이므로 원본이 직접 수정됨
- 유효하지 않은 인덱스를 전달하면 `StringIndexOutOfBoundsException` 발생

---

## `StringBuilder.setLength(int newLength)`
`setLength()` 메서드는 `StringBuilder`의 길이를 설정합니다.

### 사용법
```java
StringBuilder sb = new StringBuilder("hello world");
sb.setLength(5);
System.out.println(sb); // "hello"

```

### 특징
- 지정한 길이보다 긴 경우 문자열이 잘림
- 짧은 경우 빈 문자(`\u0000`)로 채워짐
- `StringBuilder`의 크기를 조절할 때 유용

---




