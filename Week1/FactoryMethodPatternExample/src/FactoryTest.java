public class FactoryTest {
    public static void main(String[] args) {

        DocumentFactory factory;

        // Create a Word document
        factory = new WordDocumentFactory();
        Document word = factory.createDocument();
        word.open();
        word.close();

        System.out.println("---");

        // Create a PDF document
        factory = new PdfDocumentFactory();
        Document pdf = factory.createDocument();
        pdf.open();
        pdf.close();

        System.out.println("---");

        // Create an Excel document
        factory = new ExcelDocumentFactory();
        Document excel = factory.createDocument();
        excel.open();
        excel.close();
    }
}