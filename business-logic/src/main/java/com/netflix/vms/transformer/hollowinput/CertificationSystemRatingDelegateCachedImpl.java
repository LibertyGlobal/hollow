package com.netflix.vms.transformer.hollowinput;

import com.netflix.hollow.api.objects.delegate.HollowObjectAbstractDelegate;
import com.netflix.hollow.core.read.dataaccess.HollowObjectTypeDataAccess;
import com.netflix.hollow.core.schema.HollowObjectSchema;
import com.netflix.hollow.api.custom.HollowTypeAPI;
import com.netflix.hollow.api.objects.delegate.HollowCachedDelegate;

@SuppressWarnings("all")
public class CertificationSystemRatingDelegateCachedImpl extends HollowObjectAbstractDelegate implements HollowCachedDelegate, CertificationSystemRatingDelegate {

    private final int ratingCodeOrdinal;
    private final Long ratingId;
    private final Long maturityLevel;
   private CertificationSystemRatingTypeAPI typeAPI;

    public CertificationSystemRatingDelegateCachedImpl(CertificationSystemRatingTypeAPI typeAPI, int ordinal) {
        this.ratingCodeOrdinal = typeAPI.getRatingCodeOrdinal(ordinal);
        this.ratingId = typeAPI.getRatingIdBoxed(ordinal);
        this.maturityLevel = typeAPI.getMaturityLevelBoxed(ordinal);
        this.typeAPI = typeAPI;
    }

    public int getRatingCodeOrdinal(int ordinal) {
        return ratingCodeOrdinal;
    }

    public long getRatingId(int ordinal) {
        return ratingId.longValue();
    }

    public Long getRatingIdBoxed(int ordinal) {
        return ratingId;
    }

    public long getMaturityLevel(int ordinal) {
        return maturityLevel.longValue();
    }

    public Long getMaturityLevelBoxed(int ordinal) {
        return maturityLevel;
    }

    @Override
    public HollowObjectSchema getSchema() {
        return typeAPI.getTypeDataAccess().getSchema();
    }

    @Override
    public HollowObjectTypeDataAccess getTypeDataAccess() {
        return typeAPI.getTypeDataAccess();
    }

    public CertificationSystemRatingTypeAPI getTypeAPI() {
        return typeAPI;
    }

    public void updateTypeAPI(HollowTypeAPI typeAPI) {
        this.typeAPI = (CertificationSystemRatingTypeAPI) typeAPI;
    }

}