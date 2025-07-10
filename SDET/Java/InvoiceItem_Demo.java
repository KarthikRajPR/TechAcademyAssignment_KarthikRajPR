public class InvoiceItem_Demo {
    private String invoiceId;
    private String invoiceDesc;
    private int invoiceQty;
    private double invoiceItemPrice;

    public InvoiceItem_Demo(String invoiceId, String invoiceDesc, int invoiceQty, double invoiceItemPrice) {
        this.invoiceId = invoiceId;
        this.invoiceDesc = invoiceDesc;
        this.invoiceQty = invoiceQty;
        this.invoiceItemPrice = invoiceItemPrice;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getInvoiceDesc() {
        return invoiceDesc;
    }

    public void setInvoiceDesc(String invoiceDesc) {
        this.invoiceDesc = invoiceDesc;
    }

    public int getInvoiceQty() {
        return invoiceQty;
    }

    public void setInvoiceQty(int invoiceQty) {
        this.invoiceQty = invoiceQty;
    }

    public double getInvoiceItemPrice() {
        return invoiceItemPrice;
    }

    public void setInvoiceItemPrice(double invoiceItemPrice) {
        this.invoiceItemPrice = invoiceItemPrice;
    }

    public void displayInvoice() {
        System.out.println("Invoice ID: " + invoiceId);
        System.out.println("Description: " + invoiceDesc);
        System.out.println("Quantity: " + invoiceQty);
        System.out.println("Unit Price: $" + invoiceItemPrice);

        if (invoiceQty == 1) {
            System.out.println("Total Price: $" + invoiceItemPrice);
        } else if (invoiceQty > 1) {
            double totalPrice = invoiceQty * invoiceItemPrice;
            System.out.println("Total Price (Qty x Price): $" + totalPrice);
        } else {
            System.out.println("Invalid Quantity.");
        }
    }

    public static void main(String[] args) {
        InvoiceItem_Demo item1 = new InvoiceItem_Demo("INV001", "USB Cable", 1, 5.99);
        item1.displayInvoice();

        InvoiceItem_Demo item2 = new InvoiceItem_Demo("INV002", "Wireless Mouse", 3, 15.49);
        item2.displayInvoice();
    }
}
