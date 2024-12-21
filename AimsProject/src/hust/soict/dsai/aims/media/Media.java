package hust.soict.dsai.aims.media;

import java.util.Comparator;

public abstract class Media {
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new Comparator<Media>() {
        @Override
        public int compare(Media media1, Media media2) {
            int titleComparison = media1.getTitle().compareTo(media2.getTitle());
            if (titleComparison != 0) {
                return titleComparison;
            }
            return Float.compare(media1.getCost(), media2.getCost());
        }
    };

    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new Comparator<Media>() {
        @Override
        public int compare(Media media1, Media media2) {
            int costComparison = Float.compare(media1.getCost(), media2.getCost());
            if (costComparison != 0) {
                return costComparison;
            }
            return media1.getTitle().compareTo(media2.getTitle());
        }
    };

    private int id;
    private String title;
    private String category;
    private float cost;

    public Media(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public float getCost() {
        return cost;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Media media = (Media) obj;
        return title.equals(media.title);
    }

    @Override
    public String toString() {
        return "Media " +
                "id = " + id +
                ", title: " + title +
                ", category: " + category +
                ", cost = " + cost;
    }
    public boolean isMatch(String title) {
        String[] keywords = title.split("\\s+");
        for (String word : keywords) {
            if (this.title.toLowerCase().contains(word.toLowerCase()))
                return true;
        }
        return false;
    }
}
