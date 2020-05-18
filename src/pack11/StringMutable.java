// StringBuffer AND StringBuilder

package pack11;

public class StringMutable
{
    public static void main(String[] args)
    {
        StringBuffer sbf = new StringBuffer("Severus");     // Synchronised.

        sbf.append(" Snape");
        System.out.println(sbf);

        sbf.replace(0, 7, "Harry");
        System.out.println(sbf);

        sbf.delete(2, 4);
        System.out.println(sbf);

        StringBuilder sbl = new StringBuilder("Albus");     // Non-synchronised.

        sbl.append(" Dumbledore");
        System.out.println(sbl);

        sbl.replace(0, 5, "Tom");
        System.out.println(sbl);

        sbl.delete(8, 10);
        System.out.println(sbl);
    }
}