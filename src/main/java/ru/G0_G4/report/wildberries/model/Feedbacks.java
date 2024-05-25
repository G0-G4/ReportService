package ru.G0_G4.report.wildberries.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Feedbacks {

  private Data data;
  private String error;
  private String errorText;
  private String additionalErrors;

  public static class Data {

    private int countUnanswered;
    private int countArchive;
    private List<Feedback> feedbacks;

    public int getCountUnanswered() {
      return countUnanswered;
    }

    public int getCountArchive() {
      return countArchive;
    }

    public List<Feedback> getFeedbacks() {
      return feedbacks;
    }
  }

  public static class Feedback {

    private String id;
    private int imtId;
    private int nmId;
    private int subjectId;
    private String userName;
    private String matchingSize;
    private String text;
    private String productValuation;
    private String createdDate;
    private String state;
    private Answer answer;
    private ProductDetails productDetails;
    private boolean wasViewed;
    private boolean isAbleSupplierFeedbackValuation;
    private int supplierFeedbackValuation;
    private boolean isAbleSupplierProductValuation;
    private int supplierProductValuation;
    private boolean isAbleReturnProductOrders;
    private String returnProductOrdersDate;

    public String getId() {
      return id;
    }

    public int getImtId() {
      return imtId;
    }

    public int getNmId() {
      return nmId;
    }

    public int getSubjectId() {
      return subjectId;
    }

    public String getUserName() {
      return userName;
    }

    public String getMatchingSize() {
      return matchingSize;
    }

    public String getText() {
      return text;
    }

    public String getProductValuation() {
      return productValuation;
    }

    public String getCreatedDate() {
      return createdDate;
    }

    public String getState() {
      return state;
    }

    public Answer getAnswer() {
      return answer;
    }

    public ProductDetails getProductDetails() {
      return productDetails;
    }

    public boolean isWasViewed() {
      return wasViewed;
    }

    public boolean isAbleSupplierFeedbackValuation() {
      return isAbleSupplierFeedbackValuation;
    }

    public int getSupplierFeedbackValuation() {
      return supplierFeedbackValuation;
    }

    public boolean isAbleSupplierProductValuation() {
      return isAbleSupplierProductValuation;
    }

    public int getSupplierProductValuation() {
      return supplierProductValuation;
    }

    public boolean isAbleReturnProductOrders() {
      return isAbleReturnProductOrders;
    }

    public String getReturnProductOrdersDate() {
      return returnProductOrdersDate;
    }
  }

  public static class Answer {

    private String text;
    private String state;

    public String getText() {
      return text;
    }

    public String getState() {
      return state;
    }
  }

  public static class ProductDetails {

    private int nmId;
    private int imtId;
    private String productName;
    private String supplierArticle;
    private String supplierName;
    private String brandName;
    private String size;

    public int getNmId() {
      return nmId;
    }

    public int getImtId() {
      return imtId;
    }

    public String getProductName() {
      return productName;
    }

    public String getSupplierArticle() {
      return supplierArticle;
    }

    public String getSupplierName() {
      return supplierName;
    }

    public String getBrandName() {
      return brandName;
    }

    public String getSize() {
      return size;
    }
  }

  public Data getData() {
    return data;
  }

  public String getError() {
    return error;
  }

  public String getErrorText() {
    return errorText;
  }

  public String getAdditionalErrors() {
    return additionalErrors;
  }
}
