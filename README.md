# blender-java-php
Blender Bulk SMS Platform - Send SMS via Java


### Initialize the SDK
```java
BulkXmlApi bulksms = new BulkXmlApi("USERNAME", "PASSWORD");

// Login
if (!bulksms.login()) {
    // Login incorrect
}
```



### Send SMS to single recipient
```java
// Send sms
XMLResponseWrapper response = bulksms.sendSingle(originator, recipient, body, routeId, reference);
// Get response
BatchRecipientMultiBody batchRec = (BatchRecipientMultiBody) response.getBody();
// Extract remote id
String remoteId = batchRec.getId();
```
see [demo/Demo.php](demo/Demo.php)


### Send same message to multiple recipients
```java
// Create message and set basic params
BatchMessageSingleBody batch = new BatchMessageSingleBody();
batch.setOriginator(originator);
batch.setRouteId(routeId);
batch.setBody(body);

// Add multiple recipients
for (String recipient : recipients) {
    batch.addMSISDN(recipient);
}

// Submit message
XMLResponseWrapper xmlResponseWrapper = api.sendBatch(batch);
BatchMessageSingleBody response = (BatchMessageSingleBody) xmlResponseWrapper.getBody();

// Get batch and recipient message id's. 
String batchId = response.getId();
for (BatchRecipientSingleBody recipient : response.getRecipients()) {
    String recipientId = recipient.getId();
    System.out.println(recipient.getRecipient() + " remote id: " + recipientId);
}

```


### Send multiple messages to multiple recipients
```java
// Create message and set basic params
BatchMessageMultiBody batch = new BatchMessageMultiBody();
// Route id for recipients (default, override per recipient where needed)
batch.setRouteId(routeId);
// Originator for recipients (default)
batch.setOriginator(originator);
batch.setBody("Message Text, override per recipient where needed");

// Add recipients
batch.addRecipient(recipient1);
batch.addRecipient(recipient2, "another message");
batch.addRecipient(differentOriginator, recipient2, body, reference, differentRouteId);

// Submit message
XMLResponseWrapper xmlResponseWrapper = getApi().sendBatch(batch);
BatchMessageMultiBody response = (BatchMessageMultiBody) xmlResponseWrapper.getBody();

// Get batch and recipient message id's. 
String batchId = response.getId();
for (BatchRecipientMultiBody rcpt : response.getRecipients()) {
    String recipientId = recipient.getId();
    System.out.println(recipient.getRecipient() + " remote id: " + recipientId);
}
```

### Schedule message
```java
// Get date/time for send (one hour from now)
Date scheduleTime = new Date();
Calendar cal = Calendar.getInstance();
cal.setTime(scheduleTime);
cal.add(Calendar.MINUTE, 60);
scheduleTime = cal.getTime();

// Initialize message
BatchMessageSingleBody batch = new BatchMessageSingleBody();
batch.setOriginator(originator);
batch.setRouteId(routeId);
batch.setBody(body);

// Schedule time & timezone
batch.setDeliverySchedule(schedule);
batch.setDeliveryTimeZone(TimeZone.getDefault().getID());

// Add recipients, Submit message...
```

### Receive SMS

```java
String xml = request.getParam("xml");
GenericXMLMarshaller<DeliveryMessage> marshaller = new GenericXMLMarshaller<DeliveryMessage>(DeliveryMessage.class);
DeliveryMessage message = marshaller.unmarshal(xml);
```

### Receive Receipt

```php
String xml = request.getParam("xml");
GenericXMLMarshaller<DeliveryReceipt> marshaller = new GenericXMLMarshaller<DeliveryReceipt>(DeliveryReceipt.class);
DeliveryReceipt receipt = marshaller.unmarshal(xml);

String myRef = receipt.clientReference;
String recipientId = receipt.deliveryMessageId; 
String status = receipt.status;
```

