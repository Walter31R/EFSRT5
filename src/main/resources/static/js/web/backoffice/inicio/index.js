document.addEventListener("DOMContentLoaded", function() {
  const sliderContainer = document.querySelector('.slider-container');
  const images = sliderContainer.querySelectorAll('img');

  let currentImageIndex = 0;

  function showImage(index) {
      images.forEach(image => image.style.display = 'none');
      images[index].style.display = 'block';
  }

  showImage(currentImageIndex);

  setInterval(() => {
      currentImageIndex = (currentImageIndex + 1) % images.length;
      showImage(currentImageIndex);
  }, 5000); // Change image every 5000 milliseconds (5 seconds)
});

