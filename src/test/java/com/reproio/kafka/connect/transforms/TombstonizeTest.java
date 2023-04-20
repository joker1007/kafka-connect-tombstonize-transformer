package com.reproio.kafka.connect.transforms;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;
import org.apache.kafka.connect.data.Schema;
import org.apache.kafka.connect.data.SchemaBuilder;
import org.apache.kafka.connect.data.Struct;
import org.apache.kafka.connect.sink.SinkRecord;
import org.junit.jupiter.api.Test;

@SuppressWarnings("resource")
class TombstonizeTest {

  @Test
  void testApply() {
    Tombstonize<SinkRecord> transformer = new Tombstonize<>();

    var schema =
        SchemaBuilder.struct()
            .field("key1", Schema.INT32_SCHEMA)
            .field("key2", Schema.STRING_SCHEMA)
            .build();

    Struct value = new Struct(schema);
    value.put("key1", 1);
    value.put("key2", "str");

    var record = new SinkRecord("test-topic", 1, null, "key", schema, value, 1);
    transformer.configure(Map.of());

    var result = transformer.apply(record);

    assertNull(result.value());
    assertNull(result.valueSchema());
    assertEquals(record.key(), result.key());
  }
}
