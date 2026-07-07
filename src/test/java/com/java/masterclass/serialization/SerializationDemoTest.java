package com.java.masterclass.serialization;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SerializationDemoTest {

    @Test
    void shouldSerializeAndDeserializeStudent() {
        SerializationDemo.Student student = new SerializationDemo.Student(1L, "Asha");
        byte[] data = SerializationDemo.serialize(student);
        SerializationDemo.Student restored = SerializationDemo.deserialize(data);

        assertEquals(student, restored);
    }
}
