package com.java.masterclass.serialization;

import java.io.*;

public final class SerializationDemo {
    private SerializationDemo() {}

    public record Student(long id, String name) implements Serializable {
        @Serial
        private static final long serialVersionUID = 1L;
    }

    public static byte[] serialize(Student student) {
        try (var baos = new ByteArrayOutputStream(); var oos = new ObjectOutputStream(baos)) {
            oos.writeObject(student);
            return baos.toByteArray();
        } catch (IOException e) {
            throw new IllegalStateException("Serialization failed", e);
        }
    }

    public static Student deserialize(byte[] data) {
        try (var bais = new ByteArrayInputStream(data); var ois = new ObjectInputStream(bais)) {
            return (Student) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new IllegalStateException("Deserialization failed", e);
        }
    }
}
