
package com.ilagev.dasmecp2.models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "album",
    "artists",
    "available_markets",
    "disc_number",
    "duration_ms",
    "explicit",
    "external_ids",
    "external_urls",
    "href",
    "id",
    "name",
    "popularity",
    "preview_url",
    "track_number",
    "type",
    "uri"
})
public class Track {

    @JsonProperty("album")
    private Album album;
    @JsonProperty("artists")
    private List<Artist> artists = new ArrayList<Artist>();
    @JsonProperty("available_markets")
    private List<String> availableMarkets = new ArrayList<String>();
    @JsonProperty("disc_number")
    private Integer discNumber;
    @JsonProperty("duration_ms")
    private Integer durationMs;
    @JsonProperty("explicit")
    private Boolean explicit;
    @JsonProperty("external_ids")
    private ExternalIds externalIds;
    @JsonProperty("external_urls")
    private ExternalUrls externalUrls;
    @JsonProperty("href")
    private String href;
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("popularity")
    private Integer popularity;
    @JsonProperty("preview_url")
    private String previewUrl;
    @JsonProperty("track_number")
    private Integer trackNumber;
    @JsonProperty("type")
    private String type;
    @JsonProperty("uri")
    private String uri;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The album
     */
    @JsonProperty("album")
    public Album getAlbum() {
        return album;
    }

    /**
     * 
     * @param album
     *     The album
     */
    @JsonProperty("album")
    public void setAlbum(Album album) {
        this.album = album;
    }

    /**
     * 
     * @return
     *     The artists
     */
    @JsonProperty("artists")
    public List<Artist> getArtists() {
        return artists;
    }

    /**
     * 
     * @param artists
     *     The artists
     */
    @JsonProperty("artists")
    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    /**
     * 
     * @return
     *     The availableMarkets
     */
    @JsonProperty("available_markets")
    public List<String> getAvailableMarkets() {
        return availableMarkets;
    }

    /**
     * 
     * @param availableMarkets
     *     The available_markets
     */
    @JsonProperty("available_markets")
    public void setAvailableMarkets(List<String> availableMarkets) {
        this.availableMarkets = availableMarkets;
    }

    /**
     * 
     * @return
     *     The discNumber
     */
    @JsonProperty("disc_number")
    public Integer getDiscNumber() {
        return discNumber;
    }

    /**
     * 
     * @param discNumber
     *     The disc_number
     */
    @JsonProperty("disc_number")
    public void setDiscNumber(Integer discNumber) {
        this.discNumber = discNumber;
    }

    /**
     * 
     * @return
     *     The durationMs
     */
    @JsonProperty("duration_ms")
    public Integer getDurationMs() {
        return durationMs;
    }

    /**
     * 
     * @param durationMs
     *     The duration_ms
     */
    @JsonProperty("duration_ms")
    public void setDurationMs(Integer durationMs) {
        this.durationMs = durationMs;
    }

    /**
     * 
     * @return
     *     The explicit
     */
    @JsonProperty("explicit")
    public Boolean getExplicit() {
        return explicit;
    }

    /**
     * 
     * @param explicit
     *     The explicit
     */
    @JsonProperty("explicit")
    public void setExplicit(Boolean explicit) {
        this.explicit = explicit;
    }

    /**
     * 
     * @return
     *     The externalIds
     */
    @JsonProperty("external_ids")
    public ExternalIds getExternalIds() {
        return externalIds;
    }

    /**
     * 
     * @param externalIds
     *     The external_ids
     */
    @JsonProperty("external_ids")
    public void setExternalIds(ExternalIds externalIds) {
        this.externalIds = externalIds;
    }

    /**
     * 
     * @return
     *     The externalUrls
     */
    @JsonProperty("external_urls")
    public ExternalUrls getExternalUrls() {
        return externalUrls;
    }

    /**
     * 
     * @param externalUrls
     *     The external_urls
     */
    @JsonProperty("external_urls")
    public void setExternalUrls(ExternalUrls externalUrls) {
        this.externalUrls = externalUrls;
    }

    /**
     * 
     * @return
     *     The href
     */
    @JsonProperty("href")
    public String getHref() {
        return href;
    }

    /**
     * 
     * @param href
     *     The href
     */
    @JsonProperty("href")
    public void setHref(String href) {
        this.href = href;
    }

    /**
     * 
     * @return
     *     The id
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The name
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The popularity
     */
    @JsonProperty("popularity")
    public Integer getPopularity() {
        return popularity;
    }

    /**
     * 
     * @param popularity
     *     The popularity
     */
    @JsonProperty("popularity")
    public void setPopularity(Integer popularity) {
        this.popularity = popularity;
    }

    /**
     * 
     * @return
     *     The previewUrl
     */
    @JsonProperty("preview_url")
    public String getPreviewUrl() {
        return previewUrl;
    }

    /**
     * 
     * @param previewUrl
     *     The preview_url
     */
    @JsonProperty("preview_url")
    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl;
    }

    /**
     * 
     * @return
     *     The trackNumber
     */
    @JsonProperty("track_number")
    public Integer getTrackNumber() {
        return trackNumber;
    }

    /**
     * 
     * @param trackNumber
     *     The track_number
     */
    @JsonProperty("track_number")
    public void setTrackNumber(Integer trackNumber) {
        this.trackNumber = trackNumber;
    }

    /**
     * 
     * @return
     *     The type
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * 
     * @param type
     *     The type
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 
     * @return
     *     The uri
     */
    @JsonProperty("uri")
    public String getUri() {
        return uri;
    }

    /**
     * 
     * @param uri
     *     The uri
     */
    @JsonProperty("uri")
    public void setUri(String uri) {
        this.uri = uri;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
