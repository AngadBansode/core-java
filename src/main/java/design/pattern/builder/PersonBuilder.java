package design.pattern.builder;

public class PersonBuilder {
    public static void main(String[] args) {

        // Usage
        Person person = new Person.Builder()
                .setName("John")
                .setAge(30)
                .setAddress("123 Main St")
                .build();
        System.out.println(person);
    }
}

  class Person {
    private String name;
    private int age;
    private String address;

    private Person(Builder builder) {
        this.name = builder.name;
//        this.age = builder.age;
        this.address = builder.address;
    }

      @Override
      public String toString() {
          return "Person{" +
                  "name='" + name + '\'' +
                  ", age=" + age +
                  ", address='" + address + '\'' +
                  '}';
      }

      public static class Builder {
        private String name;
        private int age;
        private String address;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
          @Override
          public String toString() {
              return super.toString();
          }

    }
}

