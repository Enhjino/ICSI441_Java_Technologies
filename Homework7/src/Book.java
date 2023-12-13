class Book {
    private final String name;
    private final Integer pageCount;

    public Book(String name, Integer pageCount) {
        this.name = name;
        this.pageCount = pageCount;
    }

    public String getName(){
        return name;
    }
    public Integer getPageCount(){
        return pageCount;
    }
    @Override
    public String toString() {
        return "Номын нэр: " + name + ", Хуудасны тоо: " + pageCount;
    }
}
