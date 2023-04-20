# Kafka Connect Join Field Transformer

This is an implementation of a kafka-connect transformer to convert record to tombstone.

# Configuration

No config.


## Example

```properties
transforms=tombstone
transforms.tombstone.type=com.reproio.kafka.connect.transforms.Tombstonize
```
