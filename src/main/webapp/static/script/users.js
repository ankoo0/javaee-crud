const dialog = document.querySelector('#modal');
const closeModalBtn = document.querySelector('#cancel-modal-btn')
const confirmAnchor = document.querySelector('.confirm-anchor');
// not working for some reason
// const closeModalBtn = document.getElementById('#cancel-modal-btn')


document.querySelectorAll('.delete-btn').forEach(btn => {
  // item.style.backgroundColor = "red"
  btn.addEventListener('click', event => {
    let userId = btn.getAttribute('id');

    confirmAnchor.setAttribute('href','http://localhost:8080/javaee-crud/users?delete=' + userId);
    // dialogConfirmBtn.appendChild(confirmAnchor);
    dialog.showModal();
  })
})

closeModalBtn.addEventListener('click', ()=>{
  dialog.close();
});
