# Kafka Connect Tombstonize Transformer

[![Java CI with Gradle](https://github.com/joker1007/kafka-connect-tombstonize-transformer/actions/workflows/build.yml/badge.svg)](https://github.com/joker1007/kafka-connect-tombstonize-transformer/actions/workflows/build.yml)

This is an implementation of a kafka-connect transformer to convert record to tombstone.

# Configuration

No config.


## Example

```properties
transforms=tombstone
transforms.tombstone.type=com.reproio.kafka.connect.transforms.Tombstonize
```
