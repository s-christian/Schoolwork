public class QueueUnderflowException extends QueueException {
	public QueueUnderflowException() {
		super("Queue Underflow");
	}
	public QueueUnderflowException(String msg) {
		super(msg);
	}
}