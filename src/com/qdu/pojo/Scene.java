package com.qdu.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Scene {
    private int sceneId;
    private String sceneName;
    private String sceneImage;
    private Integer sceneScore;

    @Id
    @Column(name = "SceneID")
    public int getSceneId() {
        return sceneId;
    }

    public void setSceneId(int sceneId) {
        this.sceneId = sceneId;
    }

    @Basic
    @Column(name = "SceneName")
    public String getSceneName() {
        return sceneName;
    }

    public void setSceneName(String sceneName) {
        this.sceneName = sceneName;
    }

    @Basic
    @Column(name = "SceneImage")
    public String getSceneImage() {
        return sceneImage;
    }

    public void setSceneImage(String sceneImage) {
        this.sceneImage = sceneImage;
    }

    @Basic
    @Column(name = "SceneScore")
    public Integer getSceneScore() {
        return sceneScore;
    }

    public void setSceneScore(Integer sceneScore) {
        this.sceneScore = sceneScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Scene scene = (Scene) o;
        return sceneId == scene.sceneId &&
                Objects.equals(sceneName, scene.sceneName) &&
                Objects.equals(sceneImage, scene.sceneImage) &&
                Objects.equals(sceneScore, scene.sceneScore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sceneId, sceneName, sceneImage, sceneScore);
    }
}
