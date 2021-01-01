package model.gpod;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class WishlistGpod {
    private String userId; //email

    private List<FavouritesGpod> favourites= new ArrayList<>();
    private Date createdTimestamp;
    private Date updatedTimestamp;

    public WishlistGpod() {
    }

    public WishlistGpod(  String userId, Date createdTimestamp, Date updatedTimestamp) {

        this.userId = userId;
        this.createdTimestamp = createdTimestamp;
        this.updatedTimestamp = updatedTimestamp;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<FavouritesGpod> getFavourites() {
        return favourites;
    }

    public void setFavourites(List<FavouritesGpod> favourites) {
        this.favourites = favourites;
    }

    public Date getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(Date createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    public Date getUpdatedTimestamp() {
        return updatedTimestamp;
    }

    public void setUpdatedTimestamp(Date updatedTimestamp) {
        this.updatedTimestamp = updatedTimestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WishlistGpod that = (WishlistGpod) o;
        return
                userId == that.userId &&
                Objects.equals(createdTimestamp, that.createdTimestamp) &&
                Objects.equals(updatedTimestamp, that.updatedTimestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash( userId, createdTimestamp, updatedTimestamp);
    }

    @Override
    public String toString() {
        return "WishlistGpod{" +
                ", userId=" + userId +
                ", createdTimestamp=" + createdTimestamp +
                ", updatedTimestamp=" + updatedTimestamp +
                '}';
    }
}
