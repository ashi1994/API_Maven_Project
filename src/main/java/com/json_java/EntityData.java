package com.json_java;

public class EntityData
{
    private String createdOn;

    private String tenantId;

    private String sortColumn;

    private String pageName;

    private String advancedFilters;

    private String filterId;

    private String isDefault;

    private String userId;

    private String sortType;

    private String filterName;

    private String displayRecords;

    private String filters;

    public String getCreatedOn ()
    {
        return createdOn;
    }

    public void setCreatedOn (String createdOn)
    {
        this.createdOn = createdOn;
    }

    public String getTenantId ()
    {
        return tenantId;
    }

    public void setTenantId (String tenantId)
    {
        this.tenantId = tenantId;
    }

    public String getSortColumn ()
    {
        return sortColumn;
    }

    public void setSortColumn (String sortColumn)
    {
        this.sortColumn = sortColumn;
    }

    public String getPageName ()
    {
        return pageName;
    }

    public void setPageName (String pageName)
    {
        this.pageName = pageName;
    }

    public String getAdvancedFilters ()
    {
        return advancedFilters;
    }

    public void setAdvancedFilters (String advancedFilters)
    {
        this.advancedFilters = advancedFilters;
    }

    public String getFilterId ()
    {
        return filterId;
    }

    public void setFilterId (String filterId)
    {
        this.filterId = filterId;
    }

    public String getIsDefault ()
    {
        return isDefault;
    }

    public void setIsDefault (String isDefault)
    {
        this.isDefault = isDefault;
    }

    public String getUserId ()
    {
        return userId;
    }

    public void setUserId (String userId)
    {
        this.userId = userId;
    }

    public String getSortType ()
    {
        return sortType;
    }

    public void setSortType (String sortType)
    {
        this.sortType = sortType;
    }

    public String getFilterName ()
    {
        return filterName;
    }

    public void setFilterName (String filterName)
    {
        this.filterName = filterName;
    }

    public String getDisplayRecords ()
    {
        return displayRecords;
    }

    public void setDisplayRecords (String displayRecords)
    {
        this.displayRecords = displayRecords;
    }

    public String getFilters ()
    {
        return filters;
    }

    public void setFilters (String filters)
    {
        this.filters = filters;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [createdOn = "+createdOn+", tenantId = "+tenantId+", sortColumn = "+sortColumn+", pageName = "+pageName+", advancedFilters = "+advancedFilters+", filterId = "+filterId+", isDefault = "+isDefault+", userId = "+userId+", sortType = "+sortType+", filterName = "+filterName+", displayRecords = "+displayRecords+", filters = "+filters+"]";
    }
}
