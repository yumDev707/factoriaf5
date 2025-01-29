document.addEventListener('DOMContentLoaded', () => {
    const editModal = document.getElementById('editModal');
    const editButtons = document.querySelectorAll('[data-target="#editModal"]');
    
    editButtons.forEach(button => {
        button.addEventListener('click', () => {
            const imageId = button.getAttribute('data-id');
            editModal.querySelector('input[name="id"]').value = imageId;
        });
    });
	
	const confirmDeleteBtn = document.getElementById('confirmDeleteBtn');
	    const deleteButtons = document.querySelectorAll('[data-target="#deleteModal"]');
	
	    for(let i of deleteButtons) {
	    	i.addEventListener('click', (event) => {
	    		const imageId = i.getAttribute('data-id');
	            confirmDeleteBtn.setAttribute('href', `/index/deleteImage?id=${imageId}`);
	    	})
	    }
});