class Kontak {
    String name;
    String phoneNumber;

    /**
     * @param name  the
     * @param phoneNumber
     */
    Kontak(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return "Nama: " + name + ", Nomor: " + phoneNumber;
    }
}