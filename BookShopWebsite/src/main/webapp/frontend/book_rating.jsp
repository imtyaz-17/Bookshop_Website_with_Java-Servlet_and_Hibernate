<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:forTokens items="${book.ratingStars}" delims="," var="star">
	<c:if test="${star eq 'On'}">
		<img src="images/rating_on.png" />
	</c:if>
	<c:if test="${star eq 'Off'}">
		<img src="images/rating_off.png" />
	</c:if>
	<c:if test="${star eq 'half'}">
		<img src="images/rating_half.png" />
	</c:if>
</c:forTokens>
