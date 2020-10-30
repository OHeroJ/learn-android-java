package site.loveli.learn_android_java.models;

import java.util.List;

public class PageData<D> {
    MetaData metadata;
    List<D> items;

    public List<D> getItems() {
        return items;
    }

    public MetaData getMetadata() {
        return metadata;
    }

    public void setItems(List<D> items) {
        this.items = items;
    }

    public void setMetadata(MetaData metadata) {
        this.metadata = metadata;
    }

    public static class MetaData {
        int per;
        int total;
        int page;

        public int getPage() {
            return page;
        }
        public void setPage(int page) {
            this.page = page;
        }
        public int getPer() {
            return per;
        }

        public void setPer(int per) {
            this.per = per;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }
    }
}
