package com.reproio.kafka.connect.transforms;

import java.util.Map;
import org.apache.kafka.common.config.ConfigDef;
import org.apache.kafka.connect.connector.ConnectRecord;
import org.apache.kafka.connect.transforms.Transformation;

public class Tombstonize<R extends ConnectRecord<R>> implements Transformation<R> {

  public static final ConfigDef CONFIG_DEF = new ConfigDef();

  @Override
  public void configure(Map<String, ?> configs) {}

  @Override
  public R apply(R record) {
    return record.newRecord(
        record.topic(),
        record.kafkaPartition(),
        record.keySchema(),
        record.key(),
        null,
        null,
        record.timestamp());
  }

  @Override
  public ConfigDef config() {
    return CONFIG_DEF;
  }

  @Override
  public void close() {}
}
